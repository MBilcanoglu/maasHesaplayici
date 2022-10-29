package maasHesaplayici;

public class Employee {
	String name;
	double salary;
	double workHours;
	int hireYear;

	Employee(String name, double salary, double workHours, int hireYear) {
		this.name = name;
		this.salary = salary;
		this.workHours = workHours;
		this.hireYear = hireYear;
	}

	double tax(double salary) {
		if (salary < 1000) {
			return 0;
		}
		return salary * 0.03;
	}

	double bonus(double workHours) {
		if (workHours > 40) {
			return (workHours - 40) * 30;
		}
		return 0;
	}

	double raiseSalary(int hireYear, double salary) {
		int year = 2021 - hireYear;
		if (year < 10) {
			return salary * 0.05;
		} else if (year < 20) {
			return salary * 0.10;
		} else {
			return salary * 0.15;
		}
	}

	@Override
	public String toString() {
		double bonusTotal = bonus(this.workHours);
		double newSalary = bonusTotal + this.salary;
		double taxTotal = tax(this.salary);
		double raiseSalaryTotal = raiseSalary(this.hireYear, this.salary);
		return "Adı: " + this.name + "\nMaaşı: " + this.salary + "\nÇalışma Saati: " + this.workHours
				+ "\nBaşlangıç Yılı: " + this.hireYear + "\nVergi: " + taxTotal + "\nBonus: " + bonusTotal
				+ "\nMaaş Artışı: " + raiseSalaryTotal + "\nVergi ve Bonuslar ile birlikte maaş: "
				+ (newSalary - taxTotal) + "\nToplam Maaş: " + (this.salary + raiseSalaryTotal);
	}

}
