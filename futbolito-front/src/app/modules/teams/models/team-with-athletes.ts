import { Athlete } from "src/app/perfil/model/athlete.model";
import { Team } from "./team";

export class TeamWithAthletes {

    team? :Team;
	athletes? : Athlete[];
}
