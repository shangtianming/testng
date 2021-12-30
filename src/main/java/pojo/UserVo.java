package pojo;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserVo {
    private int id;

    private String name;

    private Date birthday;

    private boolean vip;

    public UserVo(int id, String name, Date birthday, boolean vip) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.vip = vip;
    }
}
