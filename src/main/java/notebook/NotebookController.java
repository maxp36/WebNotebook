package notebook;

import notebook.dao.ContactRepository;
import notebook.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/contacts")
public class NotebookController {

    private final ContactRepository contactRepository;

    @Autowired
    public NotebookController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @GetMapping()
    public @ResponseBody Iterable<Contact> getContacts() {
        return contactRepository.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody Contact getContact(@PathVariable Long id) {
        return contactRepository.findOne(id);
    }

    @GetMapping(path = "/add")
    public @ResponseBody String addContact(@RequestParam String phone, @RequestParam String name) {
        Contact contact = new Contact(phone, name);
        contactRepository.save(contact);
        return "Saved";
    }

}
