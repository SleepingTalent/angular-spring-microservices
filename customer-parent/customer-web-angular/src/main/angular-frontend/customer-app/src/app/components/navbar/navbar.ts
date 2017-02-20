import {Component} from '@angular/core';
import {WebSocketService} from "../../services/websocket-service";

@Component({
  selector: 'customer-navbar',
  providers: [ WebSocketService ],
  templateUrl: 'navbar.html'
})
export default class NavbarComponent {

  messageFromServer: string;

  constructor(private wsService: WebSocketService) {

    this.wsService.createObservableSocket("ws://localhost:4444/customer-web/counter")
      .subscribe(
        data => {
          this.messageFromServer = data;
        },
        err => console.log( err),
        () =>  console.log( 'The observable stream is complete')
      );
  }

  sendMessageToServer(){
    console.log("Sending message to WebSocket server");
    this.wsService.sendMessage("Hello from client");
  }


}
