package ua.com.system.restaurant.vote.util;

import ua.com.system.restaurant.vote.model.Vote;
import ua.com.system.restaurant.vote.to.VoteDateTo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class VotesCounter {

    private VotesCounter() {
    }

    public static List<VoteDateTo> getVoteDateTos(List<Vote> votes) {
        final Map<LocalDate, Long> map = votes.stream().collect(Collectors.groupingBy(Vote::getRegistered, Collectors.counting()));
        List<VoteDateTo> votesDateTo = new ArrayList<>();
        map.forEach((k, v) -> votesDateTo.add(new VoteDateTo(k, v)));
        return votesDateTo;
    }
}
