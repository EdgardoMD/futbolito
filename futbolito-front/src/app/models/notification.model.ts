import { NotificationStatus } from "./enums/notification-status.enum";
import { NotificationType } from "./enums/notification-type.enum";

export class Notification {

    data? : any;
    idReference? : number;
    idUser? : number;
    idNotification? : number;
    statusNotification? : NotificationStatus;
    typeNotification? : NotificationType;
}
