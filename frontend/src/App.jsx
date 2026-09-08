import { useState } from "react";
import "./App.css";

function App() {

    const [username, setUsername] = useState("");
    const [user, setUser] = useState(null);
    const [activity, setActivity] = useState([]);

    const searchUser = async () => {

        if (!username.trim()) {
            return;
        }

        const response = await fetch(
            `http://localhost:8080/api/users/${username}`
        );

        const data = await response.json();

        setUser(data);

        const activityResponse = await fetch(
            `http://localhost:8080/api/users/${username}/activity`
        );

        const activityData = await activityResponse.json();

        setActivity(activityData);
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


            {/* Profile */}

            {user && (
                <div className="profile">

                    <img
                        src={user.avatar_url}
                        alt={user.login}
                        className="profile-picture"
                    />

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


            {/* Recent Activity */}

            {activity.length > 0 && (
                <div className="activity">

                    <h2>Recent Activity</h2>

                    {activity.map((event, index) => (

                        <div className="activity-item" key={index}>

                            <strong>{event.type}</strong>

                            <p>{event.repo?.name}</p>

                        </div>

                    ))}

                </div>
            )}

        </div>
    );
}

export default App;