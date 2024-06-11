import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// User class representing a user in the voting system
class User{
    private String username;
    private String password;

    // Constructor to initialize the user with a username and password
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getter for the username
    public String getUsername() {
        return username;
    }

    // Getter for the password
    public String getPassword() {
        return password;
    }
}

// Candidate class representing a candidate in the election
class Candidate {
    private String name;
    private String party;

    // Constructor to initialize the candidate with a name and party
    public Candidate(String name, String party) {
        this.name = name;
        this.party = party;
    }

    // Getter for the candidate's name
    public String getName() {
        return name;
    }

    // Getter for the candidate's party
    public String getParty() {
        return party;
    }
}

// Ballot class representing a ballot in the election
class Ballot {
    private List<Candidate> candidates;

    // Constructor to initialize the ballot
    public Ballot() {
        candidates = new ArrayList<>();
    }

    // Method to add a candidate to the ballot
    public void addCandidate(Candidate candidate) {
        candidates.add(candidate);
    }

    // Method to get the list of candidates
    public List<Candidate> getCandidates() {
        return candidates;
    }
}

// Vote class representing a vote cast by a user for a candidate
class Vote {
    private User user;
    private Candidate candidate;

    // Constructor to initialize the vote with a user and a candidate
    public Vote(User user, Candidate candidate) {
        this.user = user;
        this.candidate = candidate;
    }

    // Getter for the user
    public User getUser() {
        return user;
    }

    // Getter for the candidate
    public Candidate getCandidate() {
        return candidate;
    }
}

// VotingSystem class to manage the voting process
class VotingSystem {
    private Map<User, Boolean> votedUsers; // Tracks which users have voted

    // Constructor to initialize the voting system
    public VotingSystem() {
        votedUsers = new HashMap<>();
    }

    // Method to allow a user to cast a vote
    public void castVote(User user, Candidate candidate) {
        if (!votedUsers.containsKey(user)) {
            System.out.println(user.getUsername() + " voted for " + candidate.getName());
            votedUsers.put(user, true);
        } else {
            System.out.println(user.getUsername() + " has already voted.");
        }
    }
}

// VoteCounter class to count votes and determine election results
class VoteCounter {
    private Map<Candidate, Integer> voteCounts;

    // Constructor to initialize the vote counter
    public VoteCounter() {
        voteCounts = new HashMap<>();
    }

    // Method to count a vote for a candidate
    public void countVote(Candidate candidate) {
        voteCounts.put(candidate, voteCounts.getOrDefault(candidate, 0) + 1);
    }

    // Method to determine and print the election results
    public void determineResults() {
        System.out.println("Election Results:");
        for (Map.Entry<Candidate, Integer> entry : voteCounts.entrySet()) {
            System.out.println(entry.getKey().getName() + " (" + entry.getKey().getParty() + "): " + entry.getValue() + " votes");
        }

    }
}

public class Main{
    public static void main(String[] args) {
        // Creating users
        User user1 = new User("user1", "password1");
        User user2 = new User("user2", "password2");

        // Creating candidates
        Candidate candidate1 = new Candidate("Candidate A", "Party X");
        Candidate candidate2 = new Candidate("Candidate B", "Party Y");

        // Creating a ballot and adding candidates to it
        Ballot ballot = new Ballot();
        ballot.addCandidate(candidate1);
        ballot.addCandidate(candidate2);

        // Initializing the voting system
        VotingSystem votingSystem = new VotingSystem();
        votingSystem.castVote(user1, candidate1); // user1 casting vote for candidate1
        votingSystem.castVote(user2, candidate2); // user2 casting vote for candidate2

        // Initializing the vote counter and counting votes
        VoteCounter voteCounter = new VoteCounter();
        voteCounter.countVote(candidate1);
        voteCounter.countVote(candidate1); // Assuming user1 voted for candidate1 twice for demonstration
        voteCounter.countVote(candidate2);

        // Determining and printing the election results
        voteCounter.determineResults();
    }
}
