public class QuestionNode {
    

    public String userInput; // will hold either an answer or a question

    public QuestionNode yesAnswer; // left side
    public QuestionNode noAnswer; // right side

    // This constructor makes a leaf, it's used for answers
    public QuestionNode(String userInput) {
        this(userInput, null, null);
    }

    // This constructor makes a branch with an answer/question, a left/yes, and a right/no
    public QuestionNode(String userInput, QuestionNode yesAnswer, QuestionNode noAnswer) {
        this.userInput = userInput;
        this.yesAnswer = yesAnswer;
        this.noAnswer = noAnswer;
    }
}
