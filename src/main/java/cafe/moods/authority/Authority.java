package cafe.moods.authority;

import lombok.Data;
import org.springframework.util.Assert;

import javax.persistence.*;

/**
 * Created by Chertpong on 9/25/2016.
 */
@Data
@Entity
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    public Authority(){}

    public Authority(String name){
        Assert.hasText(name, "Authority name is required");
        this.name = name;
    }
}
