package sjcswank.notes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class NoteService {
    @Autowired
    public NoteRepository noteRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public Note createNote(String noteBody, String username) {
        Note note = noteRepository.insert(new Note(noteBody));

        mongoTemplate.update(User.class)
                .matching(Criteria.where("username").is(username))
                .apply(new Update().push("noteIds").value(note))
                .first();

        return note;
    }
}
