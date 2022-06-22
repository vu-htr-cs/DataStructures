public class Programing {
    public String language;
    public int experience;

    public Programing(String language, int experience) {
        this.language = language;
        this.experience = experience;
    }

    public void print() {
        System.out.println("Language: " + language + " - Experience: " + experience);
    }
}
