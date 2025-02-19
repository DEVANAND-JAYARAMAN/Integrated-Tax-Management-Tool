Integrated Tax System Documentation

Overview
The IntegratedTaxSystem program is designed to calculate tax values for buses and houses. It follows an object-oriented approach, utilizing inheritance, interfaces, and encapsulation to structure the classes effectively.
Class Structure

1. Vehicles (Base Class)
Represents a generic vehicle with attributes:
Reg_num: Registration number
value: Vehicle value
maxVelocity: Maximum velocity
Constructor initializes these attributes.
Getter method for Reg_num.

2. Bus (Derived from Vehicles)
Adds a new attribute:
no_of_seat: Number of seats in the bus
Constructor initializes this attribute along with base class attributes.
Getter method for no_of_seat.

3. Fixed_Property (Base Class)
Represents a generic property with attributes:
location: Property location
inCity: Boolean flag indicating if the property is in a city
estimated_value: Estimated market value of the property
Constructor initializes these attributes.
Getter method for location.

4. House (Derived from Fixed_Property)
Adds a new attribute:
area: Size of the house in square meters
Constructor initializes this attribute along with base class attributes.
Getter method for area.

5. Taxable (Interface)
Defines a method:
taxvalue(): Calculates tax value for an entity.

6. TaxableBus (Derived from Bus, Implements Taxable)
Implements taxvalue() to calculate tax:
Formula: (value / 10) + (105 * no_of_seat)

7. TaxableHouse (Derived from House, Implements Taxable)
Implements taxvalue() to calculate tax:
If property is in the city: ((estimated_value / 1000) * 5) + (0.5 * area)
Else: (estimated_value / 1000) * 3
Main Method
Uses Scanner to take user input.
Asks for the number of houses and buses.
Collects details for each house and bus.
Creates instances of TaxableHouse and TaxableBus.
Calculates and displays tax values for each entity.
