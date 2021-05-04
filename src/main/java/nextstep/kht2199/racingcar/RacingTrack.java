package nextstep.kht2199.racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 자동차들을 배치하고, 현재 위치를 기록한다.
 *
 * @see <a href="https://developerfarm.wordpress.com/2012/02/01/object_calisthenics_">더 나은 소프트웨어를 향한 9단계: 객체지향 생활 체조(9)</a>
 * @author heetaek.kim
 */
public class RacingTrack {

	private final Map<RacingCar, Integer> carPositions;

	public RacingTrack(List<RacingCar> cars) {
		this.carPositions = new HashMap<>(cars.size());
		for (RacingCar car : cars) {
			this.carPositions.put(car, 0);
		}
	}

	/**
	 * @return 이동할 것인지에 대한 여부
	 */
	protected static boolean randForMove() {
		return rand(0, 9) >= 4;
	}

	protected static int rand(int min, int max) {
		assert max > min;
		return (int) ((Math.random() * (max - min)) + min);
	}

	public void move() {
		carPositions.forEach((car, position) -> {
			int moving = randForMove() ? 1 : 0;
			carPositions.put(car,  position + moving);
		});
	}

	public List<RacingCar> findMaxPositionCars() {
		int max = 0;
		List<RacingCar> cars = new ArrayList<>();
		for (Map.Entry<RacingCar, Integer> racingCarIntegerEntry : carPositions.entrySet()) {
			Integer value = racingCarIntegerEntry.getValue();
			max = clearIfValueChange(cars, max, value);
			cars.add(racingCarIntegerEntry.getKey());
		}
		return cars;
	}

	protected int clearIfValueChange(List<RacingCar> cars, int max, Integer value) {
		if (value > max) {
			cars.clear();
		}
		return Math.max(value, max);
	}

	public Map<RacingCar, Integer> findAllCarPositions() {
		return Collections.unmodifiableMap(this.carPositions);
	}
}
