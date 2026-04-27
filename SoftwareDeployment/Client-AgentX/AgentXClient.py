import requests
import json
import sys
from typing import List

class AgentXClient:
    def __init__(self, base_url: str):
        self.base_url = base_url.rstrip("/")

    def execute_action(self, action: str, software_names: List[str]) -> dict:
        """
        Sendet einen Install/Uninstall/Reinstall-Request an den Server.
        :param action: INSTALL, UNINSTALL, REINSTALL
        :param software_names: Liste der Software-Namen
        :return: Response als dict
        """
        url = f"{self.base_url}/api/software/execute"
        payload = {
            "action": action.upper(),
            "softwareNames": software_names
        }
        try:
            response = requests.post(url, json=payload, timeout=10)
            response.raise_for_status()
            return response.json() if response.headers.get('Content-Type') == 'application/json' else {"message": response.text}
        except requests.RequestException as e:
            return {"error": str(e)}

    def install(self, software_names: List[str]) -> dict:
        return self.execute_action("INSTALL", software_names)

    def uninstall(self, software_names: List[str]) -> dict:
        return self.execute_action("UNINSTALL", software_names)

    def reinstall(self, software_names: List[str]) -> dict:
        return self.execute_action("REINSTALL", software_names)


if __name__ == "__main__":
    # Beispiel-Aufruf
    server_url = "http://localhost:8080"  # REST-API Endpoint
    client = AgentXClient(server_url)

    # Kommandozeilen-Argumente: python agentx_client.py INSTALL "Software1,Software2"
    if len(sys.argv) < 3:
        print("Usage: python agentx_client.py <ACTION> <Software1,Software2,...>")
        sys.exit(1)

    action = sys.argv[1]
    software_list = [s.strip() for s in sys.argv[2].split(",")]

    result = client.execute_action(action, software_list)
    print(json.dumps(result, indent=2))
