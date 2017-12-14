package notebook;

import notebook.dao.ContactRepository;
import notebook.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/")
public class NotebookController {

    @Autowired
    private ContactRepository contactRepository;

    @GetMapping(path = "/add")
    public @ResponseBody String addContact(@RequestParam String phone, @RequestParam String name) {
        Contact contact = new Contact(phone, name);
        contactRepository.save(contact);
        return "Saved";
    }

    @GetMapping(path = "/")
    public @ResponseBody Iterable<Contact> getContacts() {
        return contactRepository.findAll();
    }

    /*@RequestMapping("/")
    public String index() {
        return "Hello";
    }*/
}
