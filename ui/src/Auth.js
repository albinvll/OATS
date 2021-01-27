export const USERID = 'userId';

export function saveUser(userId) {
    localStorage.setItem(USERID,userId);
}

export function isLoggedIn() {
    const user = localStorage.getItem(USERID);
    return !!user;
}

export function getUserEmail() {
    return localStorage.getItem(USERID);
}

export function logout() {
    localStorage.clear();
}

