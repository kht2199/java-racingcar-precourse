package nextstep.kht2199.racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 *
 * @author heetaek.kim
 */
class RacingTrackTest {

	@RepeatedTest(value = 50)
	@MethodSource("randForMoveSource")
	@DisplayName("특정 숫자 구간에 대한 정수를 리턴하도록 랜덤함수를 구현")
	void rand() {
		int rand = RacingTrack.rand(10, 20);
		assertThat(rand)
			.isGreaterThanOrEqualTo(10)
			.isLessThanOrEqualTo(20)
		;
	}

	@ParameterizedTest
	@MethodSource("moveOrNotSource")
	@DisplayName("0~9 랜덤을 이용해 4 잇아일 경우 전진, 아닐 경우 멈춤의 조건을 구현")
	void moveOrNot(int randomValue, int baseline, boolean validation) {
		assertThat(RacingTrack.moveOrNot(randomValue, baseline))
			.isEqualTo(validation);
	}

	static Stream<Arguments> moveOrNotSource() {
		return Stream.of(
			Arguments.of(-1, 4, false),
			Arguments.of(0, 4, false),
			Arguments.of(4, 4, true),
			Arguments.of(9, 4, true)
		);
	}

	@Test
	@DisplayName("트랙의 자동차를 이동시킨다. 이동된 자동차의 현재 위치를 기록한다")
	void initialization() {
		List<RacingCar> cars = new ArrayList<>();
		cars.add(new RacingCar("car1"));
		cars.add(new RacingCar("car2"));
		RacingTrack racingTrack = new RacingTrack(cars);
		Map<RacingCar, Integer> carPositions = racingTrack.findAllCarPositions();
		assertThat(carPositions.values()).containsOnly(0);
		RacingCar sample = carPositions.keySet().iterator().next();

		int positionTo = 10;
		racingTrack.moveCar(sample, positionTo);
		assertThat(carPositions.get(sample)).isEqualTo(positionTo);
	}

}