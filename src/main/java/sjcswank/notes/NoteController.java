package sjcswank.notes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/notes")
public class NoteController {
    @Autowired
    public NoteService noteService;

    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Map<String, String> payload){
        return new ResponseEntity<Note>(noteService.createNote(payload.get("noteBody"), payload.get("username")), HttpStatus.CREATED);
    }
}
