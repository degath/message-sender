package pl.degath.message;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import pl.degath.message.infrastructure.Validator;

import java.util.UUID;

@Table
public class Message {

    @PrimaryKey
    private UUID uuid;
    private String email;
    private String title;
    private String content;
    private int magicNumber;

    private Message() {
        //required...
    }

    public Message(String email, String title, String content, int magicNumber) {
        this.uuid = UUID.randomUUID();
        //todo full email validation should be applied.
        this.email = Validator.notBlank(email, "Message email is required. Cannot be blank.");
        this.title = Validator.notBlank(title, "Message title is required. Cannot be blank.");
        this.content = Validator.notBlank(content, "Message content is required. Cannot be blank.");
        this.magicNumber = magicNumber;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getEmail() {
        return email;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getMagicNumber() {
        return magicNumber;
    }
}