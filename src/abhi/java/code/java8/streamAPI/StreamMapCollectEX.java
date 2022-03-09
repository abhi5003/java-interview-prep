package abhi.java.code.java8.streamAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class StreamMapCollectEX {
    public static void main(String[] args) {

        List<User> userList=new ArrayList<>();
        userList.add(new User(1,"Rakesh", "123", "rakesh@mail.com"));
        userList.add(new User(2,"Priyesh", "124", "priyesh@mail.com"));
        userList.add(new User(3,"Sikha", "125", "sikha@mail.com"));

        List<UserDTO> userDTOList=new ArrayList<>();
        for (User user:userList){
            userDTOList.add(new UserDTO(user.getId(), user.getUserName(), user.getEmail()));
        }

        for (UserDTO dto:userDTOList){
            System.out.println(dto);
        }

        // Using stream().map

//        userList.stream().map(new Function<User, UserDTO>() {
//            @Override
//            public UserDTO apply(User user) {
//                return new UserDTO(user.getId(), user.getUserName(), user.getEmail());
//            }
//        });

        userList.stream().map((user)-> new UserDTO(user.getId(), user.getUserName(), user.getEmail()))
                .forEach(System.out::println);
    }
}

class UserDTO{

    private int id;
    private String userName;
    private String email;

    public UserDTO(int id, String userName, String email) {
        this.id = id;
        this.userName = userName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

class User{

    private int id;
    private String userName;
    private String password;
    private String email;

    public User(int id, String userName, String password, String email) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
