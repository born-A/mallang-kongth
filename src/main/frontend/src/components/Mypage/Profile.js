import React, { useState } from 'react';
import ProfileForm from './ProfileForm';

const Profile = () => {
    const user = {
        name: '김말랑',
        email: 'mallang@gmail.com',
        imageUrl: 'https://via.placeholder.com/150',
        description: '안녕하세요. 저는 김말랑입니다.'
    };
    const [editMode, setEditMode] = useState(false);

    const handleEditMode = () => {
        setEditMode(true);
    }

    const handleCancelEditMode = () => {
        setEditMode(false);
    }

    return (
        <div>
            <h1>마이페이지</h1>
            {!editMode ? (
                <>
                    <h2>프로필</h2>
                    <div>
                        <img src={user.imageUrl} alt="프로필 사진" />
                    </div>
                    <div>
                        <p>이름: {user.name}</p>
                        <p>이메일: {user.email}</p>
                        <p>소개: {user.description}</p>
                    </div>
                    <button onClick={handleEditMode}>프로필 수정</button>
                </>
            ) : (
                <ProfileForm handleCancel={handleCancelEditMode} />
            )}
        </div>
    );
};

export default Profile;
