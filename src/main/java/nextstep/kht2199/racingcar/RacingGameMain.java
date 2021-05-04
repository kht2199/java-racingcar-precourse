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
		String[] split = carNames.split(",");
		int moveCount = acceptMoveCount();
		List<RacingCar> cars = new ArrayList<>();
		for (String carName : split) {
			cars.add(new RacingCar(carName));
		}
		RacingGame racingGame = new RacingGame(cars, moveCount);
		racingGame.start();
	}

	static String acceptCarNames() {
		while (true) {
			System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
			String carNames = SC.nextLine();
			if (validateCarNames(carNames)) {
				return carNames;
			}
		}
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

	private static boolean validateCounts(int counts) {
		return counts > 5;
	}

	private static boolean validateCarNames(String carNames) {
		return carNames.split(",").length > 1;
	}
}
