import { useState } from "react";
import "./App.css";

function App() {

    const [username, setUsername] = useState("");
    const [user, setUser] = useState(null);

    const searchUser = async () => {

        if (!username.trim()) {
            return;
        }

        const response = await fetch(
            `http://localhost:8080/api/users/${username}`
        );

        const data = await response.json();

        setUser(data);
    };

    return (
        <div className="app">

            <h1>GitHub Profile Finder</h1>

            <div className="search-box">
                <input
                    type="text"
                    placeholder="Enter GitHub username"
                    value={username}
                    onChange={(e) => setUsername(e.target.value)}
                />

                <button onClick={searchUser}>
                    Search
                </button>
            </div>

            {user && (
                <div className="profile">

                    <h2>{user.login}</h2>

                    <p>{user.bio || "No bio available"}</p>

                    <div className="stats">
                        <div>
                            <strong>{user.followers}</strong>
                            <span>Followers</span>
                        </div>

                        <div>
                            <strong>{user.following}</strong>
                            <span>Following</span>
                        </div>

                        <div>
                            <strong>{user.public_repos}</strong>
                            <span>Repositories</span>
                        </div>
                    </div>

                </div>
            )}

        </div>
    );
}

export default App;