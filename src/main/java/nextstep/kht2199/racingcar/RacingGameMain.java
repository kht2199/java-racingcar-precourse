package nextstep.kht2199.racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author heetaek.kim
 */
public class RacingGameMain {

	static final Scanner SC = new Scanner(System.in);

	public static void main(String[] args) {
		String carNames = acceptCarNames();
		int moveCount = acceptMoveCount();
		List<RacingCar> cars = manipulationCarsByNames(carNames.split(","));
		RacingGame racingGame = new RacingGame(cars, moveCount);
		racingGame.start();
	}

	static List<RacingCar> manipulationCarsByNames(String[] carNames) {
		List<RacingCar> cars = new ArrayList<>();
		for (String carName : carNames) {
			cars.add(new RacingCar(carName.trim()));
		}
		return cars;
	}

	static String acceptCarNames() {
		boolean validation = false;
		String carNames = null;
		while (!validation) {
			System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
			carNames = SC.nextLine();
			validation = validateCarNames(carNames);
		}
		return carNames;
	}

	static int acceptMoveCount() {
		boolean validation = false;
		int counts = 0;
		while (!validation) {
			System.out.println("시도할 회수는 몇회인가요?");
			counts = SC.nextInt();
			validation = validateCounts(counts);
		}
		return counts;
	}

	static boolean validateCounts(int counts) {
		return counts > 5;
	}

	static boolean validateCarNames(String carNames) {
		if (carNames.split(",").length <= 1) {
			return false;
		}
		for (String carName : carNames.split(",")) {
			if (carName.trim().length() > 5) {
				return false;
			}
		}
		return true;
	}
}
