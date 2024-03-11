package sjcswank.notes.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import sjcswank.notes.model.Note;

@Repository
public interface NoteRepository extends MongoRepository<Note, ObjectId> {

}
