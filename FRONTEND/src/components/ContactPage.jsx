import { useState } from 'react'

function ContactPage() {
    const [submitted, setSubmitted] = useState(false);
    const [formData, setFormData] = useState({
        name: '',
        email: '',
        category: '',
        userMessage: ''
    })

    const handleChange = (e) => {
        const {name, value} = e.target;
        setFormData((prevData) => ({
            ...prevData,
            [name]:value,
        }))
    }

    const handleSubmit = async (e) => {
        e.preventDefault()
        try {
            const response = await fetch('http://localhost:8080/contactUs', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(formData)
            })
            if (response.ok) {
                setSubmitted(true)
                setTimeout(() => setSubmitted(false), 4000)
                setFormData({
                    name: '',
                    email: '',
                    category: '',
                    userMessage: ''
                })
            }
        } catch (error) {
            console.error('Error sending message:', error)
        }
    }

    return (
        <div>
            {submitted && (<p>Thank you for reaching out! We'll get back to you shortly!</p>)}
            <h2>Contact Form</h2>
            <p>If you have suggestions for additional features, general questions, or need to report an issue, please fill out the form below!</p>
            <form onSubmit={handleSubmit}>
                <label>Name:
                    <input type='text' name='name' value={formData.name} onChange={handleChange} required/>
                </label><br />
                <label>Email:
                    <input type='email' name='email' value={formData.email} onChange={handleChange} required/>
                </label><br />
                <label>Category:
                    <select name='category' value={formData.category} onChange={handleChange} required>
                        <option value=''>-- Select a Category --</option>
                        <option value='general'>General Question</option>
                        <option value='bug'>Report a Bug</option>
                        <option value='feature'>Feature Request</option>
                    </select>
                </label><br />
                <label>Message:
                    <textarea name='userMessage' value={formData.userMessage} onChange={handleChange} placeholder='Your thoughts here...' rows={6} required/>
                </label><br />
                <button type='submit'>Send Message</button>
            </form>
        </div>
    )
}

export default ContactPage;