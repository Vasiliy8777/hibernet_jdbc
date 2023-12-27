package hiber.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cars")
public class Car {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(name = "model")
private String model;
@Column(name = "series")
private int series;
@OneToOne(mappedBy = "car")
private User user;

    public Car() {

    }

    public User getUser() {
    return user;
}

public void setUser(User user) {
    this.user = user;
}

@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Car car = (Car) o;
    return series == car.series && Objects.equals(id, car.id) && Objects.equals(model, car.model) && Objects.equals(user, car.user);
}

@Override
public String toString() {
    return "Car{" +
            "id=" + id +
            ", model='" + model + '\'' +
            ", series=" + series + '}';
}

@Override
public int hashCode() {
    return Objects.hash(id, model, series, user);
}

public String getModel() {
    return model;
}

public void setModel(String model) {
    this.model = model;
}

public int getSeries() {
    return series;
}

public void setSeries(int series) {
    this.series = series;
}

public Car(String model, int series) {
    this.model = model;
    this.series = series;
}

public void setId(Long id) {
    this.id = id;
}

public Long getId() {
    return id;
}
}
