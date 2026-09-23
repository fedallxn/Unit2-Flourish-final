function AboutPage() {
    return (
        <main className="about-page">
            <section className="about-title">
                <h2>About Flourish</h2>
                <p className="tagline">A little app made with a lot of love for plants and the people who care for them </p>
            </section>
            <section className="about-mission">
                <h3>Why Flourish?</h3>
                <p>
                    Flourish was born from a simple idea — plant care should feeling rewarding, not stressful!
                    Whether you have one little succulent on your desk or a sprawling collection of varying species,
                    keeping track of every plant's needs can be a lot to manage. Flourish gives you a friendly
                    place to do it, with care information just a click away!
                </p>
            </section>
            <section className="about-features">
                <h3>Some Flourishing Features</h3>
                <p>
                    With Flourish you can build your own personal plant collection, view care information like 
                    watering frequency and light requirements for each plant, and even see which plants are safe 
                    for your furry friends — because your pets matter too! If you ever re-home a plant or one 
                    completes it's circle of life, you have the ability to remove plants from your collection as well.  
                </p>
                <p>
                    In the future, I'd like to make the experience a bit more interactive and rewarding for the you all 
                    by giving each plant a health bar that depletes based on the plant's watering frequency. It would be
                    a great visual cue for when each plant would need to be watered next! There would also be an additional
                    button that would allow you to replenish the health of your plant after you've watered them.
                </p>
            </section>
            <section className="about-developer">
                <h3>Meet the Developer</h3>
                <p>
                    Hello friends, my name is Faith! I'm a student developer in LaunchCode's Women+ Part-Time Software
                    Development Cohort 2025-2026. Flourish is not only my first fully developed frontend application, but
                    it's also my Unit 1 Final project for this course. I'm really proud to see how far it's come in the past few weeks!
                    I built this app mainly because of my cat, Mouse, who thinks my plants are his personal snacks. I wanted
                    to protect him, so I thought Flourish would help me remember which plants to keep out of his reach!
                </p>
                <p>
                    When I'm not coding, you can find me putting endless hours into Legend of Zelda: Breath of the Wild, or 
                    doing something crafty like crocheting! I'm grateful to be a part of this program because I'm learning that 
                    I can create something functional but also enjoyable to use. That's rewarding in itself.
                </p>
                <div className="about-links">
                    <a href="https://github.com/fedallxn" target="_blank" rel="noreferrer">View my Github</a>
                    <a href="https://linkedin.com/in/faith-dall-b3609a203" target="_blank" rel="noreferrer">Connect on LinkedIn</a>
                </div>
            </section>
        </main>
    )
}

export default AboutPage;