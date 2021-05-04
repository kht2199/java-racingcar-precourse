package nextstep.kht2199.racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *
 * @author heetaek.kim
 */
class RacingGameConsolePrinterTest {

	static List<RacingCar> cars;

	static RacingGame racingGame;

	static Map<RacingCar, Integer> carPositions;

	@BeforeAll
	static void beforeAll() {
		RacingCar car1 = new RacingCar("car1");
		RacingCar car2 = new RacingCar("car2");
		cars = new ArrayList<>();
		cars.add(car1);
		cars.add(car2);
		racingGame = new RacingGame(cars, 10);
		carPositions = new HashMap<>();
		carPositions.put(car1, 1);
		carPositions.put(car2, 2);
	}

	@Test
	@DisplayName("진행중일 경우, 현재의 진행상황을 출력한다")
	void printStartingMessage() {
		assertThat(racingGame.printer().startingMessage(carPositions))
			.contains("car1 : -", "car2 : --");
	}

	@Test
	@DisplayName("종료됐을 경우, 가장 앞선 자동차의 우승을 출력한다")
	void printEndMessage() {
		assertThat(racingGame.printer().endMessage(cars))
			.isEqualTo("car1, car2가 최종 우승했습니다.");
	}
}