package WS.BLG.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "words")
public class WordEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "words_sequence")
//    @SequenceGenerator(sequenceName = "words_sequence",allocationSize = 1,name = "words_sequence")
    Long id;
    @Column(name = "search_value")
    String searchValue;//hello
    @Column(name = "value")
    String value;//xin chao
    @Column(name = "type_dic")
    Integer typeDic;//hashmap
    @Column(name = "id_user")
    Long userId = 0l;
    @Column(name = "career")
    Long career;
}
