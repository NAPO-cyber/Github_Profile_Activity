import { useState } from "react";
import "./App.css";

function App() {
    const [username, setUsername] = useState("");
    const [user, setUser] = useState(null);
    const [activity, setActivity] = useState([]);
    const [showActivity, setShowActivity] = useState(false);
    const [loading, setLoading] = useState(false);

    const searchUser = async () => {
        if (!username.trim()) return;

        try {
            setLoading(true);
            setShowActivity(false);

            const response = await fetch(
                `http://localhost:8080/api/users/${username.trim()}`
            );

            const data = await response.json();
            setUser(data);

            const activityResponse = await fetch(
                `http://localhost:8080/api/users/${username.trim()}/activity`
            );

            const activityData = await activityResponse.json();
            setActivity(activityData);

        } catch (error) {
            console.error("Could not fetch GitHub data", error);
            setUser(null);
            setActivity([]);
        } finally {
            setLoading(false);
        }
    };

    return (
        <div className="app">

            <div className="hero">
                {/*<p className="eyebrow">GITHUB TOOL</p>*/}

                {/*<h1>GitHub Profile Finder</h1>*/}

                <div className="search-box">
                    <input
                        type="text"
                        placeholder="Enter GitHub username"
                        value={username}
                        onChange={(e) => setUsername(e.target.value)}
                        onKeyDown={(e) =>
                            e.key === "Enter" && searchUser()
                        }
                    />

                    <button onClick={searchUser} disabled={loading}>
                        {loading ? "Searching..." : "Search"}
                    </button>
                </div>
            </div>

            {user && (
                <div className="profile">

                    <img
                        src={user.avatar_url}
                        alt={user.login}
                        className="profile-picture"
                    />

                    <h2>{user.login}</h2>

                    <p className="bio">
                        {user.bio || "No bio available"}
                    </p>

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

                    <button
                        className="activity-button"
                        onClick={() => setShowActivity(!showActivity)}
                    >
                        {showActivity ? "Hide Activity" : "Activity"}
                    </button>

                </div>
            )}

            {showActivity && (
                <div className="activity">

                    <div className="activity-header">
                        <h2>Recent Activity</h2>
                        <span>{activity.length} events</span>
                    </div>

                    {activity.length === 0 ? (
                        <p className="empty">
                            No recent activity found.
                        </p>
                    ) : (
                        activity.map((event, index) => (
                            <div
                                className="activity-item"
                                key={index}
                            >
                                <div className="activity-dot" />

                                <div>
                                    <strong>
                                        {event.type?.replace("Event", "")}
                                    </strong>

                                    <p>
                                        {event.repo?.name ||
                                            "Unknown repository"}
                                    </p>
                                </div>
                            </div>
                        ))
                    )}

                </div>
            )}

        </div>
    );
}

export default App;