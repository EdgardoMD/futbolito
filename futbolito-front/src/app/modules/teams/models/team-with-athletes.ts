import { Athlete } from "../../perfil/model/athlete.model";
import { Team } from "./team";

export interface  TeamWithAthletes {

    teamDto :Team ;
	athletesDto : Athlete[] ;
}
