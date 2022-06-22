public class Member {
    String name;
    String email;

    public Member(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Member [name=" + name + ", email=" + email + "]";
    }
}
