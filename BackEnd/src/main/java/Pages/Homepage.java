package Pages;

import JDBC.Receive;

/**
 * Created by EvanKing on 11/14/15.
 */
public class Homepage {
    int mealsDonated;
    int mealsServed;
    int currentlyAvailable;

    public Homepage() {
        this.mealsDonated = Receive.totalMealsDonated();
        this.mealsServed = Receive.totalMealsServed();
        this.currentlyAvailable = Receive.currentlyAvailable();
    }

    @Override
    public String toString() {
        return "Homepage{" +
                "mealsDonated=" + mealsDonated +
                ", mealsServed=" + mealsServed +
                ", currentlyAvailable=" + currentlyAvailable +
                '}';
    }
}
