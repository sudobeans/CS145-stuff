public class QuestionNode {
    

    public String input; // will hold either an answer or a question

    public QuestionNode yesAnswer; // left side
    public QuestionNode noAnswer; // right side

    // This constructor makes a leaf, it's used for answers
    public QuestionNode(String input) {
        this(input, null, null);
    }

    // This constructor makes a branch with an answer/question, a left/yes, and a right/no
    public QuestionNode(String input, QuestionNode yesAnswer, QuestionNode noAnswer) {
        this.input = input;
        this.yesAnswer = yesAnswer;
        this.noAnswer = noAnswer;
    }
}
