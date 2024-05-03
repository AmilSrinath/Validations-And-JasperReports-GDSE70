package lk.ijse.gdse70.Model.TM;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Amil Srinath
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerTM {
    private String id;
    private String name;
    private String address;
    private String contact;
    private String nic;
    private String email;
    private String salary;
    private String age;
}
