New-Item -ItemType Directory -Force -Path "frontend/src"

@"
{
 "name": "agentx-dashboard",
 "version": "1.0.0",
 "private": true,
 "dependencies": {
  "react": "^18.2.0",
  "react-dom": "^18.2.0",
  "sockjs-client": "^1.6.1",
  "stompjs": "^2.3.3"
 }
}
"@ | Out-File frontend/package.json

@"
import React, { useEffect, useState } from 'react';
import SockJS from 'sockjs-client';
import Stomp from 'stompjs';

export default function App() {

 const [events, setEvents] = useState([]);

 useEffect(() => {
  const socket = new SockJS('http://localhost:8080/ws');
  const client = Stomp.over(socket);

  client.connect({}, () => {
   client.subscribe('/topic/events', (msg) => {
    setEvents(prev => [...prev, msg.body]);
   });
  });
 }, []);

 return (
  <div>
   <h1>AgentX Control Center</h1>
   <ul>
    {events.map((e,i) => <li key={i}>{e}</li>)}
   </ul>
  </div>
 );
}
"@ | Out-File frontend/src/App.js