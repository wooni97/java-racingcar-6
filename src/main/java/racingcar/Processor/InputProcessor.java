package racingcar.Processor;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.ErrorMessage;
import racingcar.utils.StringParser;

import java.util.List;

public class InputProcessor {

    public List<String> readCarNames() {
        String inputCarNames = Console.readLine();
        List<String> carNames = StringParser.splitString(inputCarNames);

        carNames.stream()
                .filter(Validator::isEmptyOrWhiteSpaceOnly)
                .findAny()
                .ifPresent(name -> {
                        throw new IllegalStateException(ErrorMessage.INVALID_NAME_EMPTY_MESSAGE);
                });

        return carNames;
    }

    public int readTrialNumber() {
        String trialNumber =  Console.readLine().trim();
        if (!Validator.IsNumber(trialNumber)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TRIALNUMBER_IS_NOT_NUMBER_MESSAGE);
        }

        return Integer.parseInt(trialNumber);
    }
}
