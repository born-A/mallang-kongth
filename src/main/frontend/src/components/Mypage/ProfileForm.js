import React, { useState } from 'react';

const ProfileForm = () => {
    const [name, setName] = useState('');
    const [description, setDescription] = useState('');
    const [image, setImage] = useState('');

    const handleNameChange = (event) => {
        setName(event.target.value);
    };

    const handleDescriptionChange = (event) => {
        setDescription(event.target.value);
    };

    const handleImageChange = (event) => {
        setImage(event.target.files[0]);
    };

    const handleSubmit = (event) => {
        event.preventDefault();
        // 프로필 수정 API 호출 및 저장 로직 구현
    };

    return (
        <form onSubmit={handleSubmit}>
            <div>
                <label htmlFor="name">이름:</label>
                <input
                    type="text"
                    id="name"
                    value={name}
                    onChange={handleNameChange}
                />
            </div>
            <div>
                <label htmlFor="description">소개:</label>
                <textarea
                    id="description"
                    value={description}
                    onChange={handleDescriptionChange}
                />
            </div>
            <div>
                <label htmlFor="image">프로필 사진:</label>
                <input type="file" id="image" onChange={handleImageChange} />
            </div>
            <button type="submit">저장</button>
        </form>
    );
};

export default ProfileForm;
