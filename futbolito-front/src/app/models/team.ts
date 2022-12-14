export class Team {

    id?: number;
    teamLevel?: string;
    score?: number;
    name?: string;
    city?: string;
    idTeamLevel?: number;
    idCity?: number;
    idsAthletes?: number[];
    isMyTeam?: boolean;
	isGuest?: boolean;


    constructor(name?: string, idCity?: number) {
        this.name = name;
        this.idCity = idCity;
       
    }
}
