export class NewUser {

   name?: string;
    
   lastName?: string;
    
   nickname?: string;
    
   phone?: string;
    
   email?: string;
    
   password?: string;
    
   confirmationPassword?: string;

   constructor(name: string, lastName: string, nickname: string, phone: string,
       email: string, password: string, confirmationPassword: string) {
        this.name = name ;
        this.lastName = lastName ;
        this.nickname = nickname ;
        this.phone = phone ;
        this.email = email ;
        this.password = password ;
        this.confirmationPassword = confirmationPassword ;

   }
}
