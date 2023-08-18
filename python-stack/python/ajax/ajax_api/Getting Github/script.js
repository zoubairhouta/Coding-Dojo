function fetchGitHubRepositories() {
    const username = "adion81"; // Replace with your GitHub username
    const url = `https://api.github.com/users/${username}/repos`;

    fetch(url)
        .then(response => response.json())
        .then(data => {
            const reposContainer = document.getElementById("reposContainer");
            reposContainer.innerHTML = ""; // Clear previous content

            data.forEach(repo => {
                const repoName = repo.name;
                const repoURL = repo.html_url;

                const repoElement = document.createElement("p");
                repoElement.innerHTML = `<a href="${repoURL}" target="_blank">${repoName}</a>`;
                reposContainer.appendChild(repoElement);
            });
        })
        .catch(error => {
            console.error("Error fetching GitHub repositories:", error);
            const reposContainer = document.getElementById("reposContainer");
            reposContainer.innerHTML = "An error occurred while fetching repositories.";
        });
}
