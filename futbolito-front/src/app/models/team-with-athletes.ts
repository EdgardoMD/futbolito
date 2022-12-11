import { Athlete } from "./athlete.model";
import { Team } from "./team";

export interface  TeamWithAthletes {

    teamDto :Team ;
	athletesDto : Athlete[] ;
}
