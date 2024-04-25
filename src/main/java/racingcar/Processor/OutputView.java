package racingcar.Processor;

import racingcar.constant.GameMessage;
import racingcar.domain.RaceResult;

import java.util.List;

public class OutputView {

    public void displayCarNamesInputMessage() {
        System.out.println(GameMessage.GAME_START_MESSAGE);
    }

    public void displayNumberOfTrialsQuestion() {
        System.out.println(GameMessage.ASK_TRIAL_NUMBERS_MESSAGE);
    }

    public void displayRoundResultMessage() {
        printBlankLine();
        System.out.println(GameMessage.ROUND_RESULT);
    }

    public void displayRaceResults(List<RaceResult> raceResults) {
        raceResults.stream()
                .flatMap(raceResult ->
                        raceResult.getRaceResult().entrySet().stream())
                .forEach(entry ->
                        System.out.println(entry.getKey() + " : " + getFormattedPosition(entry.getValue())));

    }

    public void displayWinners(List<String> winnerNames) {
        System.out.print(GameMessage.WINNER_MESSAGE);
        System.out.println(String.join(", ", winnerNames));

    }

    public String getFormattedPosition(int position) {
        return "-".repeat(position);
    }

    public void printBlankLine() {
        System.out.println();
    }
}
