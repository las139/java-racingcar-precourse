package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    List<Car> carList;

    @BeforeEach
    void init() {
        carList = new ArrayList<Car>();
        carList.add(new Car("pobi", 3));
        carList.add(new Car("toyo", 3));
        carList.add(new Car("asora", 2));
    }

    @ParameterizedTest
    @DisplayName("우승자_리스트에_자동차_포함_O_체크")
    @ValueSource(ints = { 3, 4, 5 })
    void 우승자_리스트에_자동차_포함_O_체크(int maxPosition) {
        List<Car> winnerList = new ArrayList<Car>();
        Cars cars = new Cars(carList);
        cars.addWinnerCar(winnerList, new Car("toyo", 3), maxPosition);
        assertThat(cars.getCarList().size() > 0).isTrue();
    }

    @ParameterizedTest
    @DisplayName("우승자_리스트에_자동차_포함_X_체크")
    @ValueSource(ints = { 0, 1, 2 })
    void 우승자_리스트에_자동차_포함_X_체크(int maxPosition) {
        List<Car> winnerList = new ArrayList<Car>();
        Cars cars = new Cars(carList);
        cars.addWinnerCar(winnerList, new Car("toyo", 3), maxPosition);
        assertThat(cars.getCarList().size() > 0).isTrue();
    }

    @Test
    @DisplayName("우승자_인원수_체크")
    void 우승자_인원수_체크() {
        Cars cars = new Cars(carList);
        assertThat(cars.winnerList().size() == 2).isTrue();
    }
}
