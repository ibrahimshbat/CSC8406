package Answer;
/**
 * A class to simulate the football game. Using random decisions.
 * 
 * @author Nursultan Kenenbayev
 * @version 23/10/2015
 */
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import com.google.common.collect.Multimap;

import Answer.Player.Position;

public class LeagueSimulation {

	public static void main(String[] args) throws DuplicatePlayer, PlayerNotInClub {
		Player davidOspina = new GoalKeeper("David Ospina", 1.80, "31/8/1988", Position.GOAL_KEEPER);
		Player petrCech = new GoalKeeper("Petr Cech", 1.78, "20/3/1982", Position.GOAL_KEEPER);
		
		Player kieranGibbs = new Player("Kieran Gibbs", 1.75, "26/9/1986", Position.DEFENDER);
		Player nachoMonreal = new Player("Nacho Monreal", 1.82, "21/5/1993", Position.DEFENDER);
		Player gabriel = new Player("Gabriel", 1.73, "26/11/1990", Position.DEFENDER);
		Player hectorBellerin = new Player("Hector Bellerin", 1.86, "19/3/1995", Position.DEFENDER);
		Player laurentKoscielny = new Player("Laurent Koscielny", 1.80, "10/9/1985", Position.DEFENDER);
		Player calumChambers = new Player("Calum Chambers", 1.82, "20/1/1995", Position.DEFENDER);
		Player perMertesacker = new Player("Per Mertesacker", 1.81, "10/9/1990", Position.DEFENDER);
		
		Player tomasRosicky = new Player("Tomas Rosicky", 1.85, "04/10/1980", Position.MIDFIELDER);
		Player mikelArteta = new Player("Mikel Arteta", 1.70, "26/3/1982", Position.MIDFIELDER);
		Player santiCazorla  = new Player("Santi Cazorla", 1.95,  "13/12/1984", Position.MIDFIELDER);
		Player mesutOzil = new Player("Mesut Ozil", 1.80, "15/10/1988", Position.MIDFIELDER);
		Player jackWilshere = new Player("Jack Wilshere", 1.90, "01/1/1992", Position.MIDFIELDER);
		Player aaronRamsey = new Player("Aaron Ramsey", 1.86, "02/2/1991", Position.MIDFIELDER);
		Player francisCoquelin = new Player("Francis Coquelin", 1.89, "13/11/1989", Position.MIDFIELDER);
		
		Player nursultan = new Player("Nursultan", 1.75, "25/9/1993", Position.FORWARD);
		Player alexis = new Player("Alexis", 1.75, "19/12/1988", Position.FORWARD);
		Player oliverGiround = new Player("Oliver Giround", 1.80,"21/5/1982", Position.FORWARD);
		Player dannyWelbeck = new Player("Danny Welbeck", 1.78, "22/12/1981", Position.FORWARD);
		
		Club arsenal = new Club("Arsenal", "Emirates Stadium");
		arsenal.addPlayer(oliverGiround);
		arsenal.addPlayer(dannyWelbeck);
		arsenal.addPlayer(aaronRamsey);
		arsenal.addPlayer(francisCoquelin);
		arsenal.addPlayer(nursultan);
		arsenal.addPlayer(jackWilshere);
		arsenal.addPlayer(laurentKoscielny);
		arsenal.addPlayer(calumChambers);
		arsenal.addPlayer(perMertesacker);
		arsenal.addPlayer(petrCech);
		arsenal.addPlayer(santiCazorla);
		arsenal.addPlayer(davidOspina);
		arsenal.addPlayer(kieranGibbs);
		arsenal.addPlayer(nachoMonreal);
		arsenal.addPlayer(gabriel);
		arsenal.addPlayer(hectorBellerin);
		arsenal.addPlayer(tomasRosicky);
		arsenal.addPlayer(mikelArteta);
		arsenal.addPlayer(mesutOzil);
		arsenal.addPlayer(alexis);
		System.out.println("Arsenal, players average age: " + arsenal.getAverageAge() + ", average height: "
						   + arsenal.getAverageHeight());
		
		Player asmirBegovic = new GoalKeeper("Asmir Begovic", 1.75, "20/6/1987", Position.GOAL_KEEPER);
		Player marcoAmelia = new GoalKeeper("Marco Amelia", 1.78, "02/4/1982", Position.GOAL_KEEPER);
		Player jamalBlackman = new GoalKeeper("Jamal Blackman", 1.99, "27/10/1993", Position.GOAL_KEEPER);
		
		Player cesarAzpilicueta = new Player("Cesar Azpilicueta", 1.78, "28/8/1989", Position.DEFENDER);
		Player garyCahill = new Player("Gary Cahill", 1.93, "19/12/1985", Position.DEFENDER);
		Player branislavIvanovic = new Player("Branislav Ivanovic", 1.85, "22/2/1984", Position.DEFENDER);
		Player johnTerry = new Player("John Terry", 1.87, "07/12/1980", Position.DEFENDER);
		Player kurtZouma = new Player("Kurt Zouma", 1.90, "27/10/1994", Position.DEFENDER);
		Player olaAina = new Player("Ola Aina", 1.89, "08/10/1996", Position.DEFENDER);
		Player babaRahman = new Player("Baba Rahman", 1.79, "02/7/1994", Position.DEFENDER);
		
		Player oscar = new Player("Oscar", 1.79, "09/9/1991", Position.MIDFIELDER);
		Player pedro = new Player("Pedro", 1.85, "28/7/1987", Position.MIDFIELDER);
		Player ramires = new Player("Ramires", 1.80, "24/3/1987", Position.MIDFIELDER);
		Player willian = new Player("Willian", 1.75,  "09/8/1988", Position.MIDFIELDER);
		Player edenHazard = new Player("Eden Hazard", 1.73, "07/1/1991", Position.MIDFIELDER);
		Player cescFabregas = new Player("Cesc Fabregas", 1.75, "05/5/1987", Position.MIDFIELDER);
		Player rubenLoftus = new Player("Ruben Loftus", 1.91, "21/1/1996", Position.MIDFIELDER);
		
		Player diegoCosta = new Player("Diego Costa", 1.80, "07/10/1988", Position.FORWARD);
		Player falcao = new Player("Falcao", 1.77, "10/2/1986", Position.FORWARD);
		Player loicRemy = new Player("Loic Remy", 1.85, "02/1/1987", Position.FORWARD);
		
		Club chelsea = new Club("Chelsea", "Stamford Bridge");
		chelsea.addPlayer(loicRemy);
		chelsea.addPlayer(edenHazard);
		chelsea.addPlayer(cescFabregas);
		chelsea.addPlayer(rubenLoftus);
		chelsea.addPlayer(marcoAmelia);
		chelsea.addPlayer(babaRahman);
		chelsea.addPlayer(olaAina);
		chelsea.addPlayer(kurtZouma);
		chelsea.addPlayer(jamalBlackman);
		chelsea.addPlayer(asmirBegovic);
		chelsea.addPlayer(willian);
		chelsea.addPlayer(cesarAzpilicueta);
		chelsea.addPlayer(garyCahill);
		chelsea.addPlayer(branislavIvanovic);
		chelsea.addPlayer(johnTerry);
		chelsea.addPlayer(oscar);
		chelsea.addPlayer(pedro);
		chelsea.addPlayer(ramires);
		chelsea.addPlayer(diegoCosta);
		chelsea.addPlayer(falcao);
		System.out.println("Chelsea, players average age: " + chelsea.getAverageAge() + ", average height: "
				           + chelsea.getAverageHeight());
		
		
		Player ryanFulton = new GoalKeeper("Ryan Fulton", 1.80, "20/8/1990", Position.GOAL_KEEPER);
		Player adamBogdan = new GoalKeeper("Adam Bogdan", 1.95, "27/9/1987", Position.GOAL_KEEPER);
		
		Player connorRandall = new Player("Connor Randall", 1.75, "25/9/1991", Position.DEFENDER);
		Player ryanCleary = new Player("Ryan Cleary", 1.82, "21/5/1987", Position.DEFENDER);
		Player tomBrewit = new Player("Tom Brewit", 1.73, "21/2/1989", Position.DEFENDER);
		Player bradSmith = new Player("Brad Smith", 1.86, "20/8/1979", Position.DEFENDER);
		Player christianBenteke = new Player("Christian Benteke", 1.90, "3/12/1990", Position.DEFENDER);
		
		Player adamPhillips = new Player("Adam Phillips", 1.85, "12/9/1980", Position.MIDFIELDER);
		Player mattyVirtue = new Player("Matty Virtue", 1.70, "10/8/1985", Position.MIDFIELDER);
		Player yanDhanda = new Player("Yan Dhanda", 1.95,  "15/9/1986", Position.MIDFIELDER);
		Player alexOhanlon = new Player("Alex O'Hanlon", 1.80, "12/3/1988", Position.MIDFIELDER);
		
		
		Player ryanKent = new Player("Ryan Kent", 1.75, "29/1/1987", Position.FORWARD);
		Player jackDunn = new Player("Jack Dunn", 1.75, "25/9/1987", Position.FORWARD);
		
		Club liverpool = new Club("Liverpool", "Anfield");
		liverpool.addPlayer(ryanFulton);
		liverpool.addPlayer(adamBogdan);
		liverpool.addPlayer(yanDhanda);
		liverpool.addPlayer(jackDunn);
		liverpool.addPlayer(connorRandall);
		liverpool.addPlayer(ryanCleary);
		liverpool.addPlayer(tomBrewit);
		liverpool.addPlayer(bradSmith);
		liverpool.addPlayer(adamPhillips);
		liverpool.addPlayer(mattyVirtue);
		liverpool.addPlayer(alexOhanlon);
		liverpool.addPlayer(ryanKent);
		liverpool.addPlayer(christianBenteke);
		System.out.println("Liverpool, players average age: " + liverpool.getAverageAge() + ", average height: "
				           + liverpool.getAverageHeight());
		System.out.println("");
		
		Player willyCabalero = new GoalKeeper("Willy Cabalero", 1.80, "28/9/1981", Position.GOAL_KEEPER);
		Player joeHart = new GoalKeeper("Joe Hart", 1.84, "19/4/1987", Position.GOAL_KEEPER);
		Player richardWright = new GoalKeeper("Richard Wright", 1.90, "05/11/1977", Position.GOAL_KEEPER);
		Player nicolasOtamendi = new Player("Nicolas Otamendi", 1.82, "12/2/1988", Position.DEFENDER);
		Player gaelClichy = new Player("Gael Clichy", 1.84,"26/7/1985", Position.DEFENDER);
		Player martinDemichelis = new Player("Martin Demichelis", 1.88, "21/8/1985",  Position.DEFENDER);
		Player aleksandarKolarov = new Player("Aleksandar Kolarov", 1.90, "10/11/1985", Position.DEFENDER);
		Player bacarySagna = new Player("Bacary Sagna", 1.78, "14/2/1983", Position.DEFENDER);
		Player pabloZabaleta = new Player("Pablo Zabaleta", 1.86, "16/1/1985", Position.DEFENDER);
		Player vincentKompany = new Player("Vincent Kompany", 1.83, "10/4/1986", Position.DEFENDER);
		Player fabianDelph = new Player("Fabian Delph", 1.79, "21/10/1989", Position.MIDFIELDER);
		Player samirNasri = new Player("Samir Nasri", 1.81, "26/6/1987", Position.MIDFIELDER);
		Player jesusNavas = new Player("Jesus Navas", 1.82, "21/11/1985", Position.MIDFIELDER);
		Player davidSilva = new Player("David Silva", 1.78, "08/1/1986", Position.MIDFIELDER);
		Player kevinDeBruyne = new Player("Kevin De Bruyne", 1.80, "28/6/1991", Position.MIDFIELDER);
		Player raheemSterling = new Player("08/12/1994", 1.85, "08/12/1994", Position.MIDFIELDER);
		Player yayaToure = new Player("Yaya Toure", 1.77, "13/5/1983", Position.MIDFIELDER);
		Player sergioAguero = new Player("Sergio Aguero", 1.89, "02/6/1988", Position.FORWARD);
		Player wilfriedBony = new Player("Wilfried Bony", 1.91, "10/12/1988", Position.FORWARD);
		Player edinDzeko = new Player("Edin Dzeko", 1.87, "17/3/1986", Position.FORWARD);
		Player kelechiIheanacho = new Player("Kelechi Iheanacho", 1.79, "12/4/1988", Position.FORWARD);
		
		Club manCity = new Club("Manchester City", "City of Manchester Stadium");
		manCity.addPlayer(willyCabalero);
		manCity.addPlayer(joeHart);
		manCity.addPlayer(richardWright);
		manCity.addPlayer(nicolasOtamendi);
		manCity.addPlayer(gaelClichy);
		manCity.addPlayer(martinDemichelis);
		manCity.addPlayer(aleksandarKolarov);
		manCity.addPlayer(bacarySagna);
		manCity.addPlayer(pabloZabaleta);
		manCity.addPlayer(vincentKompany);
		manCity.addPlayer(fabianDelph);
		manCity.addPlayer(samirNasri);
		manCity.addPlayer(jesusNavas);
		manCity.addPlayer(davidSilva);
		manCity.addPlayer(kevinDeBruyne);
		manCity.addPlayer(raheemSterling);
		manCity.addPlayer(yayaToure);
		manCity.addPlayer(sergioAguero);
		manCity.addPlayer(wilfriedBony);
		manCity.addPlayer(edinDzeko);
		manCity.addPlayer(kelechiIheanacho);
		System.out.println("Manchester City, players average age: " + manCity.getAverageAge() + ", average height: "
						   + manCity.getAverageHeight());
		
		Player davidDeGea = new GoalKeeper("David De Gea", 1.84, "07/11/1990", Position.GOAL_KEEPER);
		Player victorValdes = new GoalKeeper("Victor Valdes", 1.95, "14/1/1982", Position.GOAL_KEEPER);
		Player samJohnStone = new GoalKeeper("Sam Johnstone", 1.87, "25/3/1993", Position.GOAL_KEEPER);
		
		Player philJones = new Player("Phil Jones", 1.80, "21/2/1992", Position.DEFENDER);
		Player marcosRojo = new Player("Marcos Rojo", 1.81, "20/3/1990", Position.DEFENDER);
		Player chrisSmalling = new Player("Chris Smalling", 1.75, "22/11/1989", Position.DEFENDER);
		Player lukeShaw = new Player("Luke Shaw", 1.87, "12/7/1995", Position.DEFENDER);
		Player paddyMcnair = new Player("Paddy Mcnair", 1.82, "27/4/1995", Position.DEFENDER);
		Player matteoDarmian = new Player("Matteo Darmian", 1.82, "02/12/1989", Position.DEFENDER);
		Player tylerBlackett = new Player("Tyler Blackett", 1.85, "02/4/1984", Position.DEFENDER);
		
		Player andreasPereir = new Player("Andreas Pereira", 1.79, "01/1/1996", Position.MIDFIELDER);
		Player nickPowell = new Player("Nick Powell", 1.84, "23/3/1994", Position.MIDFIELDER);
		Player juanMata = new Player("Juan Mata", 1.82, "28/4/1988", Position.MIDFIELDER);
		Player anderHerrera = new Player("Ander Herrera", 1.81, "14/8/1989", Position.MIDFIELDER);
		Player marouaneFellaini = new Player("Marouane Fellaini", 1.86, "22/11/1987", Position.MIDFIELDER);
		Player morganSchneiderlin = new Player("Morgan Schneiderlin", 1.83, "08/11/1989", Position.MIDFIELDER);
		Player bastianSchweinsteiger = new Player("Bastian Schweinsteiger", 1.87, "01/8/1984", Position.MIDFIELDER);
		
		Player wayneRooney = new Player("Wayne Rooney", 1.81, "24/10/1985", Position.FORWARD);
		Player anthonyMartial = new Player("Anthony Martial", 1.82, "05/12/1995", Position.FORWARD);
		Player willKeane = new Player("Will Keane", 1.87, "11/1/1993", Position.FORWARD);
		
		Club manUtd = new Club("Manchester United", "Old Trafford");
		manUtd.addPlayer(davidDeGea);
		manUtd.addPlayer(victorValdes);
		manUtd.addPlayer(samJohnStone);
		manUtd.addPlayer(philJones);
		manUtd.addPlayer(marcosRojo);
		manUtd.addPlayer(chrisSmalling);
		manUtd.addPlayer(lukeShaw);
		manUtd.addPlayer(paddyMcnair);
		manUtd.addPlayer(matteoDarmian);
		manUtd.addPlayer(tylerBlackett);
		manUtd.addPlayer(andreasPereir);
		manUtd.addPlayer(nickPowell);
		manUtd.addPlayer(juanMata);
		manUtd.addPlayer(anderHerrera);
		manUtd.addPlayer(marouaneFellaini);
		manUtd.addPlayer(morganSchneiderlin);
		manUtd.addPlayer(bastianSchweinsteiger);
		manUtd.addPlayer(wayneRooney);
		manUtd.addPlayer(anthonyMartial);
		manUtd.addPlayer(willKeane);
		
		League league = new League("barclays");
		league.addClub(arsenal);
		league.addClub(chelsea);
		league.addClub(liverpool);
		league.addClub(manCity);
		league.addClub(manUtd);
		
		league.addFixture(arsenal, chelsea);
		league.addFixture(arsenal, liverpool);
		league.addFixture(arsenal, manCity);
		league.addFixture(arsenal, manUtd);
		league.addFixture(chelsea, arsenal);
		league.addFixture(chelsea, liverpool);
		league.addFixture(chelsea, manCity);
		league.addFixture(chelsea, manUtd);
		league.addFixture(liverpool, arsenal);
		league.addFixture(liverpool, chelsea);
		league.addFixture(liverpool, manCity);
		league.addFixture(liverpool, manUtd);
		league.addFixture(manCity, arsenal);
		league.addFixture(manCity, chelsea);
		league.addFixture(manCity, manUtd);
		league.addFixture(manCity, liverpool);
		league.addFixture(manUtd, arsenal);
		league.addFixture(manUtd, chelsea);
		league.addFixture(manUtd, liverpool);
		league.addFixture(manUtd, manCity);

		startLeague(league);
		league.printLeagueTable();
		
	}
	private static void startLeague(League league){
		Multimap<Club, Club> matches = league.getMatchesToBePlayed();
		Iterator<Entry<Club, Collection<Club>>> it = matches.asMap().entrySet().iterator();
		while(it.hasNext()){
			// One key can have multiple values
			Entry<Club, Collection<Club>> pair = it.next();
			// Get key
			Club club = pair.getKey();
			// Iterate through collection of values(clubs)
			for(Club _club : pair.getValue()){
				// Club who will play in left hand side will play at home
				// Which means the place will be club who will play at home
				Match match = new Match(club.getStadiumName(), "12/10/2015 18:55", club, _club);
				System.out.println(match.getPlayingClubs());
				match.setGame();
				// Simulate a match
				Simulation simulation = new Simulation(match);
				simulation.game();
				// Record mathes
				league.addPlayedMatches(simulation.getMatch());
			}
		}
	}
}
