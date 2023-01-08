import { Athlete } from "./athlete.model";
import { Team } from "./team";

export interface  TeamWithAthletes {

    teamDto :Team ;
	athletesOfTeam : Athlete[] ;
    athletesGuest:  Athlete[] ;

}
