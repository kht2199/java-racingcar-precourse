package nextstep.kht2199.racingcar;

import static java.lang.System.*;

import java.util.List;
import java.util.Map;

/**
 *
 * {@link RacingGame}의 상태에 따른 경기상황 출력
 * 1. 경기중일시 이동거리
 * 2. 경기종료시 우승자 출력
 *
 * @author heetaek.kim
 */
public class RacingGameConsolePrinter {

	private final RacingTrack track;

	private final RacingGame game;

	public RacingGameConsolePrinter(RacingGame game, RacingTrack track) {
		this.track = track;
		this.game = game;
	}

	public void print() {
		if (game.started()) {
			printStartingMessage(track.findAllCarPositions());
			return;
		}
		if (game.ended()) {
			printEndMessage(track.findMaxPositionCars());
		}
	}

	protected String repeat(String ch, int repeat) {
		assert false;
		return new String(new char[repeat]).replace("\0", ch);
	}

	private void printStartingMessage(Map<RacingCar, Integer> carPositions) {
		carPositions.forEach((car, position) ->
			out.println(car.carName() + " : " + repeat("-", position))
		);
		out.println();
	}

	private void printEndMessage(List<RacingCar> maxPositionCars) {
		String[] carNames = new String[maxPositionCars.size()];
		for (int i = 0; i < maxPositionCars.size(); i++) {
			RacingCar car = maxPositionCars.get(i);
			carNames[i] = car.carName();
		}
		out.println(String.join(", ", carNames) + "가 최종 우승했습니다.");
	}

}
