import { Athlete } from "src/app/perfil/model/athlete.model";
import { Team } from "./team";

export interface  TeamWithAthletes {

    teamDto :Team ;
	athletesDto : Athlete[] ;
}
