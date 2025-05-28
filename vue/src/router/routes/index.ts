import type { RouteRecordRaw } from 'vue-router';

const routes: RouteRecordRaw[] = [
  {
    path: '/',
    name: 'login',
    component: () => import('@/views/login.vue'),
    meta: {
      title: '登录',
    },
  },
  //学生
  {
    path: '/student-dashboard',
    name: 'StudentDashboard',
    component: () => import('@/views/StudentDashboard.vue'),
    meta: {
      title: '学生仪表板',
      requiresAuth: true,
      role: 'student'
    },
    redirect: '/student-dashboard/personal-info',
    children: [
      {
        path: 'personal-info',
        name: 'sPersonalInfo',
        //？逆天了这里的名字不能重名
        component: () => import('@/views/student/PersonalInfo.vue'),
        meta: {
          title: '个人信息',
        },
      },
      {
        path: 'view-grades',
        name: 'ViewGrades',
        component: () => import('@/views/student/ViewGrades.vue'),
        meta: {
          title: '查看成绩',
        },
      },
      {
        path: 'view-schedule',
        name: 'ViewSchedule',
        component: () => import('@/views/student/ViewSchedule.vue'),
        meta: {
          title: '查看课表',
        },
      },
      {
        path: 'submit-application',
        name: 'SubmitApplication',
        component: () => import('@/views/student/SubmitApplication.vue'),
        meta: {
          title: '提交申请',
        },
      },
    ],
  },
  //教师
  {
    path: '/teacher-dashboard',
    name: 'TeacherDashboard',
    component: () => import('@/views/TeacherDashboard.vue'),
    meta: {
      title: '教师仪表板',
      requiresAuth: true,
      role: 'teacher'
    },
    redirect: '/teacher-dashboard/personal-info',
    children: [
      {
        path: 'view-schedule',
        name: 'TeacherViewSchedule',
        component: () => import('@/views/teacher/ViewSchedule.vue'),
        meta: {
          title: '查看课表',
        },
      },
      {
        path: 'handle-approval',
        name: 'HandleApproval',
        component: () => import('@/views/teacher/HandleApproval.vue'),
        meta: {
          title: '处理审批',
        },
      },
      {
        path: 'enter-grades',
        name: 'EnterGrades',
        component: () => import('@/views/teacher/EnterGrades.vue'),
        meta: {
          title: '录入成绩',
        },
      },
      {
        path: 'personal-info',
        name: 'PersonalInfo',
        component: () => import('@/views/teacher/PersonalInfo.vue'),
        meta: {
          title: '个人信息',
        },
      },
      {
        path: 'view-student',
        name: 'ViewStudent',
        component: () => import('@/views/teacher/ViewStudent.vue'),
        meta: {
          title: '个人信息',
        },
      },
    ],
  },
  //管理员
  {
    path: '/manager-dashboard',
    name: 'ManagerDashboard',
    component: () => import('@/views/ManagerDashboard.vue'),
    meta: {
      title: '管理员仪表板',
      requiresAuth: true,
      role: 'manager'
    },
    redirect: '/manager-dashboard/student-management',
    children: [
      {
        path: 'major-management',
        name: 'MajorManagement',
        component: () => import('@/views/manager/MajorManagement.vue'),
        meta: {
          title: '专业管理',
        },
      },
      {
        path: 'class-management',
        name: 'ClassManagement',
        component: () => import('@/views/manager/ClassManagement.vue'),
        meta: {
          title: '班级管理',
        },
      },
      {
        path: 'classroom-management',
        name: 'ClassroomManagement',
        component: () => import('@/views/manager/ClassroomManagement.vue'),
        meta: {
          title: '课室管理',
        },
      },
      {
        path: 'student-management',
        name: 'StudentManagement',
        component: () => import('@/views/manager/StudentManagement.vue'),
        meta: {
          title: '学生管理',
        },
      },
      {
        path: 'teacher-management',
        name: 'TeacherManagement',
        component: () => import('@/views/manager/TeacherManagement.vue'),
        meta: {
          title: '教师管理',
        },
      },
      {
        path: 'admin-management',
        name: 'AdminManagement',
        component: () => import('@/views/manager/AdminManagement.vue'),
        meta: {
          title: '管理员管理',
        },
      },
    ],
  },
];

export default routes;
