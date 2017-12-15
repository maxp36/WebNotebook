package notebook;

import notebook.dao.ContactRepository;
import notebook.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(path = "/contacts")
public class NotebookController {

    private final ContactRepository contactRepository;

    @Autowired
    public NotebookController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @GetMapping()
    public ResponseEntity<Iterable<Contact>> getContacts() {
        return new ResponseEntity<Iterable<Contact>>(contactRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContact(@PathVariable Long id) {
        return new ResponseEntity<Contact>(contactRepository.findOne(id), HttpStatus.OK);
    }

    /*@GetMapping("/add")
    public @ResponseBody String addContact(@RequestParam String phone, @RequestParam String name) {
        Contact contact = new Contact(phone, name);
        contactRepository.save(contact);
        return "Saved";
    }*/

    @PostMapping()
    public ResponseEntity<Contact> add(@RequestBody Contact contact) {
        Contact result = contactRepository.save(new Contact(contact.getPhone(), contact.getName()));
        return new ResponseEntity<Contact>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contact> update(@PathVariable Long id, @RequestBody Contact contact) {
        Contact result = contactRepository.findOne(contact.getId());
        if (result.getId().equals(id)) {
            result = contactRepository.save(contact);
        }
        return new ResponseEntity<Contact>(result, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteContact(@PathVariable Long id) {
        contactRepository.delete(id);

        return new ResponseEntity(HttpStatus.OK);
    }

}
