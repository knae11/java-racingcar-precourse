package racingcar;

import java.util.Scanner;
import utils.ConstantUtils;

public class PlayerResponse {

    private final Scanner scanner;
    private final Validator validator;

    public PlayerResponse(Scanner scanner) {
        this.scanner = scanner;
        validator = new Validator();
    }

    public String[] getCarNames() {
        String[] carNames;
        while (true) {
            try {
                System.out.println(ConstantUtils.ASKING_NAMES_MESSAGE);
                carNames = responseOfCarNames();
                validator.checkCarNames(carNames);
                return carNames;
            } catch (IllegalArgumentException i) {
                System.out.println(i.getMessage());
            }
        }
    }

    public int getHowManyMoves() {
        while (true) {
            try {
                System.out.println(ConstantUtils.ASKING_MOVES_MESSAGE);
                String movesBeforeCheck = responseOfMoves();
                validator.checkNumber(movesBeforeCheck);
                return Integer.parseInt(movesBeforeCheck);
            } catch (IllegalArgumentException i) {
                System.out.println(i.getMessage());
            }
        }
    }

    private String[] responseOfCarNames() {
        String[] carNames = scanner.nextLine().split(ConstantUtils.NAMES_DELIMITER, -1);
        return deleteWhiteSpace(carNames);
    }

    private String[] deleteWhiteSpace(String[] carNames) {
        for (int i = 0; i < carNames.length; i++) {
            carNames[i] = carNames[i].trim();
        }
        return carNames;
    }

    private String responseOfMoves() {
        return scanner.nextLine().trim();
    }

}